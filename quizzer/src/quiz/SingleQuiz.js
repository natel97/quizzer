import React, { Component } from 'React';


class SingleQuiz extends React.Component{
  constructor(a, b){
    super(a, b);

    this.render = () => {

      return(
        <div>
          <h1>{this.props.data.title}</h1>
        </div>
      )
    }
  }
}

export default SingleQuiz
