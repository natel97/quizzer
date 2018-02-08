import React, { Component }  from 'react'
import { Request } from '../Request'
import { browserHistory } from 'react-router'

class LoginMain extends React.Component {

  constructor(props, context){
    super(props, context);
    this.state = {
      login: {
        username: "",
        password: ""
      }
    }

    this.logIn = (event) => {
      Request.user.token({
        email: this.state.login.username,
        pwHash: this.state.login.password
      }).then((data) => {
        if(data.status === 200){
          localStorage.setItem('token', data.data);
          this.props.route.login(data.data)
          browserHistory.push('/quiz')
        }
      })
    }

    this.updateInfo = (event) => {
      const login = this.state.login
      if (event.target.placeholder === "Username"){
        login.username = event.target.value
      }
      else{
        login.password = event.target.value
      }
      this.setState(login: login)
    }

    this.render = () => {

      return(
        <div>
          <input onChange={this.updateInfo} type="text" placeholder="Username" value={this.state.login.username}></input>
          <input onChange={this.updateInfo} type="password" placeholder="Password" value={this.state.login.password}></input>
          <input
          type="submit"
          value="Log in"
          onClick={this.logIn}
          ></input>
        </div>
      )
    }
  }
}

export default LoginMain
