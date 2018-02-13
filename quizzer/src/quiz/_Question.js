import React, { Component } from "react"

class _Question extends Component{
  constructor(a, b){
    super(a, b);
    console.log(a.data.correctAnswer);
    console.log(b);
    this.state = {
      answers: this.props.data.answers,
      correctAnswer: this.props.data.correctAnswer === null ? {id: -1} : this.props.data.correctAnswer
    };
    this.render = () => {
      return(
        <div>
          <h4>{this.props.data.question}</h4>
          {this.props.data.answers.map((x) => {
            return (
              <div>
                <p onClick={() => {
                  let correctAnswer = this.state.correctAnswer;
                  correctAnswer.id = x.id;
                  this.setState(correctAnswer);
                  this.props.correctAnswerFunction(this.props.data.id, x.id)
                }}>{x.id === this.state.correctAnswer.id ? <b>**{x.answer}**</b> : x.answer }</p>
              </div>
            )
          })}
        </div>
      )
    }
  }
}

export default _Question
