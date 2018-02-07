import axios from 'axios'

const BASE = "http://localhost:8080"

export const APP_VARS = {
  loggedIn: false,
  token: ""
}

export const Request =  {
  user: {
    new: (user) => axios.post(`${BASE}/users`, user).then(data => {
      return data;
    }),
    find: (id) => axios.get(`${BASE}/users/${id}`),
    token: (user) => axios.post(`${BASE}/users/getToken`, user)
  },
  quiz:{
    new: (quiz) => axios.post(`${BASE}/quiz`, quiz),
    all: () =>   axios.get(`${BASE}/quiz`),
    get: (id) => axios.get(`${BASE}/quiz/${id}`),
    addQuestions: (id, questions) => {
      questions.forEach(q => {
        if(q.question.length > 3 && q.answers.length > 1)
          axios.post(`${BASE}/quiz/${id}`, q).catch((a) => console.log(q))
      })
    }
  },
  question: {
  setCorrect: (questionID, answerID) => axios.post(`${BASE}/question/${questionID}/correct`,{
    id: answerID
  })}
};

export default{
  Request,
  APP_VARS
}
