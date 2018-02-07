import React, {Component} from 'react'

class _Quiz extends React.Component{
  constructor(a, b){
    super(a, b)
    this.render = () => {
      return(
        <div class="quiz-card">
          <a href={"/quiz/" + this.props.data.id}><h3>Title: {this.props.data.title}</h3></a>
          <a href="#"><h6>Created by: {this.props.data.author.name} </h6></a>
        </div>
      )
    }
  }
}

export default _Quiz
