import React, { Component } from 'react'
import {Request} from '../Request'
import { browserHistory } from 'react-router'
import  _Question from './_Question'

class SingleQuizPage extends Component{
  constructor(a, b){
    super(a, b)
    this.state = {
      questions: [{
          answers: [],
          correctAnswer: {
            id: 0
          }}
      ],
      author: {
        name: ""
      },
      addedQuestions: [{
        key: 0,
        question: "",
        answers: [{
          key: 0,
          answer: ""
        }]
      }]
    }


    this.setCorrectAnswer = (questionID, answerID) => {
      let questions = this.state.questions
      questions.filter((x) => x.id == questionID)[0].correctAnswer = {
        id: answerID
      }
      console.log(questionID)
      console.log(answerID)
      this.setState(questions);
    }

    Request.quiz.get(this.props.params.id).then((data) => {
      console.log(data)
      let quiz = this.state.quiz
      quiz = data.data
      this.setState(quiz: quiz)
    }).catch(() => {
      browserHistory.push("/")
      console.log("404 NOT FOUND")
    })

    this.changeValue = (event) => {
      let addedQuestions = this.state.addedQuestions;
      switch(event.target.placeholder[0]){
        case 'Q':
          addedQuestions[event.target.name].question = event.target.value;
          break;
        case 'A':
          console.log(event.target.name.split("|"))
          addedQuestions[event.target.name.split("|")[0]].answers[event.target.name.split("|")[1]].answer = event.target.value
          break;
      }
      this.setState(addedQuestions)
    }

    this.render = () => {
      return(
        <div>
          <h2>{`${this.state.author.name}\'s quiz: ${this.state.title}`}</h2>
          <hr />
          {this.state.questions.map((x) => {
            return(
              <div>
                <_Question data={x} correctAnswerFunction={this.setCorrectAnswer} />
              </div>
            )
          })}

          {this.state.addedQuestions.map((y) => {
            return(
            <div>
              <input type="text" value={y.question} placeholder={`Question #${y.key}`} name={y.key} onChange={this.changeValue} />
              {
                y.answers.map((x => {
                return(
                  <input type="text" value={x.answer} placeholder={`Answer #${x.key}`} name={`${y.key}|${x.key}`} onChange={this.changeValue} />
                )
              }))}
              <input type="submit" value="Add Answer" onClick={() => {
                let addedQuestions = this.state.addedQuestions
                addedQuestions[y.key].answers.push({
                  key: addedQuestions[y.key].answers.length,
                  answer: ""
                })
                this.setState(addedQuestions)
              }} />
            </div>
          )})}
          <input type="submit" value="Add Question" onClick={() => {
            const addedQuestions = this.state.addedQuestions
            console.log(addedQuestions)
            addedQuestions.push({
              key: addedQuestions.length,
              question: "",
              answers: [{
                key: 0,
                answer: ""
              }]
            })
            this.setState(addedQuestions: addedQuestions)
          }} />
          <input type="submit" value="Save" onClick={() => {
            Request.quiz.addQuestions(this.state.id, this.state.addedQuestions)
            this.state.questions.forEach((x) => {
              if(x.correctAnswer !== null)
              Request.question.setCorrect(x.id, x.correctAnswer.id)
            })
          }} />
        </div>
      )
    }
  }
}

export default SingleQuizPage
