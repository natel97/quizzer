import React, { Component }  from 'react'
import axios from 'axios'


class QuizIndex extends Component {
  constructor(a, b){
    super(a, b)
    this.state = {
      data: []
    }
    axios.get("http://localhost:8080/quiz").then((data) => {
      this.setState(data: data.data)
      console.log(this.state.data)
    })
    this.render = () => {
      return(
        <div>
          {
            this.state.data.map(x =>
              <div key={x.id}>
                <p>Title: {x.title}</p>
                <p>Created by: {x.author.name}</p>
              </div>
            )
          }
            <a href="/quiz/new">New Quiz</a>
      </div>

    )}
  }
}

export default QuizIndex
