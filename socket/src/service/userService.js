import axios from 'axios'
import { BASE_URL, header } from '../environment';
export const login = (credentials) => {
  return axios.post(BASE_URL + '/v1/user/login', credentials, {});
}

export const register = (user) => {
  return axios.post(BASE_URL + '/v1/user/save', user, {});
}

export const getAllUser = () => {
  return axios.get(BASE_URL + '/v1/user/all');
}