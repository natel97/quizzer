import React, { Component }  from 'react'
import axios from 'axios'
import {browserHistory} from 'react-router';

class NewQuiz extends Component {
  constructor(a, b){
    super(a,b)

    this.state = {
      quiz: {
        title: ""
      }
    }

    this.createQuiz = () => {
      axios.post('http://localhost:8080/quiz', {
        title: this.state.quiz.title,
        author: {id: 1}
      }).then((data) => {
        console.log(data)
        if(data.status === 200){
          console.log("Status is 200!")
          browserHistory.push('/quiz')
        }
      })
    }

    this.updateFields = (event) => {
      const quiz = this.state.quiz;
      quiz.title = event.target.value;
      this.setState(quiz: quiz)
    }

    this.render = () => {
      return (
        <div>
          <input
            type="text"
            placeholder="Title"
            value={this.state.quiz.title}
            onChange={this.updateFields}>
          </input>
          <input
            type="submit"
            value="Create Quiz"
            onClick={this.createQuiz}>
          </input>
        </div>
      )
    }
  }
}

export default NewQuiz
