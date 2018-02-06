import axios from 'axios'

const BASE = "http://localhost:8080"

export const APP_VARS = {
  loggedIn: false,
  name: ""
}

export const Request =  {
  user: {
    new: (user) => axios.post(`${BASE}/users`, user).then(data => {
      console.log(data)
      return data;
    }),
    find: (id) => axios.get(`${BASE}/users/${id}`),
    token: (user) => axios.post(`${BASE}/users/getToken`, user)
  },
  quiz:{
    new: (quiz) => axios.post(`${BASE}/quiz`, quiz),
    all: () =>   axios.get(`${BASE}/quiz`)
  }
};

export default{
  Request,
  APP_VARS
}
