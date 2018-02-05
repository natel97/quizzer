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


ReactDOM.render(
    <Router history={browserHistory}>
      <div>
        <Route exact path="/" component={LoginPage} />
        <Route path="/user/:id" component={MainPage} />
        <Route path="/quiz" component={QuizIndex} />
        <Route path="/quiz/new" component={NewQuiz} />
      </div>
    </Router>
  , document.getElementById('root'));
registerServiceWorker();
