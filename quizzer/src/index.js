import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import registerServiceWorker from './registerServiceWorker';
import { Router, browserHistory } from 'react-router';
import { Request } from './Request'
import {
  Route
} from 'react-router-dom';

import LoginPage from './login_page/LoginMain'
import MainPage from './main_page/MainPage'
import QuizIndex from './quiz/QuizIndex'
import NewQuiz from './quiz/NewQuiz'
import NavBar from './navbar/navbar'
import SignupPage from './signup_page/SignupPage'
import SingleQuizPage from './quiz/SingleQuizPage'
import NewSessionPage from './quiz/NewSessionPage'



let token = localStorage.getItem('token');

const login = {
  id: -1,
  name: ""
};

let loginFunc = (token) => {
  Request.user.findByToken(token).then((data) => {
    login.id = data.data.id;
    login.name = data.data.name
  })
};

if(token !== null){
  loginFunc(token)
}



ReactDOM.render(
  <div id="entire-page">
  <NavBar login={login}/>
  <div id="body">
    <Router history={browserHistory}>
      <div>
        <Route exact path="/" component={MainPage} />
        <Route path="/user/:id" component={MainPage} />
        <Route path="/quiz" component={QuizIndex} />
        <Route path="/quiz/new" component={NewQuiz} />
        <Route path="/quiz/:id" component={SingleQuizPage} />
        <Route path="/login" component={LoginPage} login={loginFunc}/>
        <Route path="/signup" component={SignupPage} />
        <Route path="/quiz/:id/session" component={NewSessionPage} />
        <Route path="*" component={MainPage} />
      </div>
    </Router>
    </div>
    </div>
  , document.getElementById('root'));
registerServiceWorker();
