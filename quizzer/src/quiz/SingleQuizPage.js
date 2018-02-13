import React, { Component } from 'react'
import {Request} from '../Request'
import { browserHistory } from 'react-router'
import  Question from './_Question'

class SingleQuizPage extends Component{
  constructor(a, b){
    super(a, b);
    this.state = {
      loaded: {done: false},
      questions: [
      ],
      author: {},
      addedQuestions: []
    };


    this.setCorrectAnswer = (questionID, answerID) => {
      let questions = this.state.questions;
      questions.filter((x) => x.id === questionID)[0].correctAnswer = {
        id: answerID
      };
      this.setState(questions);
    };

    Request.quiz.get(this.props.params.id).then((data) => {
      let quiz = this.state.quiz;
      quiz = data.data;
      this.setState(quiz);
      let loaded = this.state.loaded;
      loaded.done = true;
      this.setState(loaded);
      console.log(quiz)
    }).catch(() => {
      browserHistory.push("/");
      console.log("404 NOT FOUND")
    });

    this.changeValue = (event) => {
      let addedQuestions = this.state.addedQuestions;
      switch(event.target.placeholder[0]){
        case 'Q':
          addedQuestions[event.target.name].question = event.target.value;
          break;
        case 'A':
          addedQuestions[event.target.name.split("|")[0]].answers[event.target.name.split("|")[1]].answer = event.target.value;
          break;
          default:
            break;
      }
      this.setState(addedQuestions)
    };

    this.render = () => {
      return this.state.loaded.done ? (
        <div>
          <h2>{`${this.state.author.name}'s quiz: ${this.state.title}`}</h2>
          <hr />
          {this.state.questions.map((x) => {
            return (
              <div>
                <Question data={x} correctAnswerFunction={this.setCorrectAnswer} />
              </div>
            )
          })}

          {this.state.addedQuestions.map((y) => {
            return (
            <div>
              <input type="text" value={y.question} placeholder={`Question #${y.key}`} name={y.key} onChange={this.changeValue} />
              {
                y.answers.map((x => {
                return(
                  <input type="text" value={x.answer} placeholder={`Answer #${x.key}`} name={`${y.key}|${x.key}`} onChange={this.changeValue} />
                )
              }))}
              <input type="submit" value="Add Answer" onClick={() => {
                let addedQuestions = this.state.addedQuestions;
                addedQuestions[y.key].answers.push({
                  key: addedQuestions[y.key].answers.length,
                  answer: ""
                });
                this.setState(addedQuestions)
              }} />
            </div>
          )})}
          <input type="submit" value="Add Question" onClick={() => {
            const addedQuestions = this.state.addedQuestions;
            addedQuestions.push({
              key: addedQuestions.length,
              question: "",
              answers: [{
                key: 0,
                answer: ""
              }]
            });
            this.setState(addedQuestions);
          }} />
          <input type="submit" value="Save" onClick={() => {
            Request.quiz.addQuestions(this.state.id, this.state.addedQuestions);
            this.state.questions.forEach((x) => {
              if(x.correctAnswer !== null)
              Request.question.setCorrect(x.id, x.correctAnswer.id)
            });
              window.location.reload()
          }} />
          <a href={`/quiz/${this.props.params.id}/session`}>Create a session!</a>
        </div>
      ) : (
        <p>Fetching Quiz...</p>
      )
    }
  }
}

export default SingleQuizPage
