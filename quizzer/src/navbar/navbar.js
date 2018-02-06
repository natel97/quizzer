import React, { Component } from 'react'

class NavBar extends React.Component{
  constructor(a, b){
    super(a,b)

    this.render = () => {

      return (
        <div id="nav-bar">
          <a href="/login">Login</a>
          <a href="/quiz">Quizzes</a>
          <a href="/">Home</a>
          <a href="/signup">Sign Up</a>
        </div>
      )
    }

  }

}

export default NavBar
