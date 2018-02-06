import React, {Component} from 'react'
import axios from 'axios'
import {browserHistory} from 'react-router';
import { Request } from '../Request'

class SignupPage extends React.Component{
  constructor(a, b){
    super(a,b)

    this.state = {
      login: {
        email: "",
        password: "",
        confirm: "",
        name: ""
      },
      message: {
        message: ""
      }
    }

    this.createUser = () => {
      if(this.state.login.password === this.state.login.confirm){
        Request.user.new({
          email: this.state.login.email,
          pwHash: this.state.login.password,
          name: this.state.login.name
      }).then((data) => {
        console.log(data)
        if(data.status === 200){
          Request.user.token({
            email: this.state.login.email,
            pwHash: this.state.login.password
          }).then((data) => {
            console.log(data)
            if(data.status === 200){
              localStorage.setItem('token', data.data);
              browserHistory.push("/quiz")
            }
          })

        }
      })}
      else {
        const message = this.state.message
        message.message = "Error: Passwords do not match!"
        this.setState(message)
        console.log(this.state.message.message)
      }
    }

    this.onChange = (event) => {
      const login = this.state.login
      switch(event.target.placeholder){
        case "Email":
          login.email = event.target.value
          break;
        case "Password":
          login.password = event.target.value
          break;
        case "Confirm Password":
          login.confirm = event.target.value
          break
        case "Name":
          login.name = event.target.value
      }
      this.setState(login: login)
    }

    this.render = () => {
      return (
        <div>
        <input type="text"
        value={this.state.login.email}
        placeholder="Email"
        onChange={this.onChange}/>

        <input type="password"
        value={this.state.login.password}
        placeholder="Password"
        onChange={this.onChange}/>

        <input type="password"
        value={this.state.login.confirm}
        placeholder="Confirm Password"
        onChange={this.onChange}/>

        <input type="text"
        value={this.state.login.name}
        placeholder="Name"
        onChange={this.onChange}/>

        <input type="submit"
        value="Create User"
        onClick={this.createUser}
        />
        <br />
        <label value={this.state.message.message} />
        </div>
      )
    }
  }
}

export default SignupPage
