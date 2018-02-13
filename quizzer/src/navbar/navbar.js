import React from 'react'

class NavBar extends React.Component{
  constructor(a, b){
    super(a,b);
    console.log(this.props.login.id);

    this.componentWillReceiveProps = (nextProps) => {
    if(this.props.login.id !== JSON.stringify(nextProps.login.id))
    {
           console.log(nextProps.login.id + ":  HAS BEEN UPDATED")
    }
};
    this.render = () => {
      return (
        <div id="nav-bar">
          {this.props.login.id === -1 ? <a href="/login">Login</a> : <a href={`/user/${this.props.login.id}`}>{this.props.login.name}</a>}
          <a href="/quiz">Quizzes</a>
          <a href="/">Home</a>
          <a href="/signup">Sign Up</a>
        </div>
      )
    }
  }
}

export default NavBar
