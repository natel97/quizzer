import React, { Component } from 'react'
import { Request } from '../Request'

class NewSessionPage extends Component{
  constructor(a, b){
    super(a, b);
    this.state = {
      users: [],
      data: {
        allUsers: [],
        currentName: ""
      }
    };

    Request.user.all().then((info) => {
    console.log(info);
    const data = this.state.data;
    data.allUsers = info.data;
    this.setState(data)
    });



    this.render = () => {
      return (
        <div>
          <input list="users" name="users" placeholder="user" value={this.state.data.currentName} onChange={((event) => {

            const data = this.state.data;
            data.currentName = event.target.value;
            this.setState(data)
          })} />
            <datalist id="users">
              {this.state.data.allUsers.map((x) => {
                return(
                  <option value={x.name} />
                )
              })}
            </datalist>
            <input type="submit" value="Add" onClick={(event) => {
              if(this.state.data.allUsers.filter((x) => x.name === this.state.data.currentName).length === 0)
                return;
              const users = this.state.users;
              users.push(this.state.data.currentName);
              this.setState(users);
              const data = this.state.data;
              data.currentName = "";
              this.setState(data)
            }}/>

            <p>Adding {this.state.users.map((x) => {
              return(<b>{x}, </b>)
            })}</p>
        </div>
      )
    }
  }
}

export default NewSessionPage
