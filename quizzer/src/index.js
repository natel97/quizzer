import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import App from './App';
import { Provider } from 'react-redux';
import registerServiceWorker from './registerServiceWorker';
import { Router, browserHistory } from 'react-router';
import {
  HashRouter,
  Link,
  Route
} from 'react-router-dom';

import LoginPage from './login_page/LoginMain'
import MainPage from './main_page/MainPage'
import QuizIndex from './quiz/QuizIndex'
import NewQuiz from './quiz/NewQuiz'
import NavBar from './navbar/navbar'
import SignupPage from './signup_page/SignupPage'


ReactDOM.render(
  <div id="entire-page">
  <NavBar />
  <div id="body">
    <Router history={browserHistory}>
      <div>
        <Route exact path="/" component={MainPage} />
        <Route path="/user/:id" component={MainPage} />
        <Route path="/quiz" component={QuizIndex} />
        <Route path="/quiz/new" component={NewQuiz} />
        <Route path="/login" component={LoginPage} />
        <Route path="/signup" component={SignupPage} />
        <Route path="*" component={MainPage} />
      </div>
    </Router>
    </div>
    </div>
  , document.getElementById('root'));
registerServiceWorker();
