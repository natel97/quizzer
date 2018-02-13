import React, { Component }  from 'react'
import { browserHistory } from 'react-router';
import {Request}  from '../Request'

class NewQuiz extends Component {
  constructor(a, b){
    super(a,b);

    this.state = {
      quiz: {
        title: ""
      }
    };

    this.createQuiz = () => {
      Request.quiz.new({
        quiz: {
          title: this.state.quiz.title
        },
        token:  localStorage.getItem("token")
      }).then((data) => {
        if(data.status === 200){
          browserHistory.push('/quiz/' + data.data.id)
        }
      })
    };

    this.updateFields = (event) => {
      const quiz = this.state.quiz;
      quiz.title = event.target.value;
      this.setState(quiz)
    };

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
