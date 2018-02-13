import React, { Component }  from 'react'
import { Request } from '../Request'
import Quiz from './_Quiz'


class QuizIndex extends Component {
  constructor(a, b){
    super(a, b);
    this.state = {
      data: []
    };
  Request.quiz.all().then((data) => {
      this.setState(data.data);
      console.log(this.state.data)
    });
    this.render = () => {
      return(
        <div>
          <div id="quiz-index">
          {
            this.state.data.map(x =>
              <Quiz data={x} />
            )
          }
          </div>
        <a href="/quiz/new">New Quiz</a>
      </div>
    )}
  }
}

export default QuizIndex
