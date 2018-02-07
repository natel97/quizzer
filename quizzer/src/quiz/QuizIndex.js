import React, { Component }  from 'react'
import axios from 'axios'
import { Request } from '../Request'
import _Quiz from './_Quiz'


class QuizIndex extends Component {
  constructor(a, b){
    super(a, b)
    this.state = {
      data: []
    }
  Request.quiz.all().then((data) => {
      this.setState(data: data.data)
      console.log(this.state.data)
    })
    this.render = () => {
      return(
        <div>
          <div id="quiz-index">
          {
            this.state.data.map(x =>
              <_Quiz data={x} />
            )
          }
          </div>
        <a href="/quiz/new">New Quiz</a>
      </div>
    )}
  }
}

export default QuizIndex
