import  axios from 'axios'
import { BASE_URL } from '../environment';
export const  toDO = (credentials) =>{
  return  axios.post(BASE_URL + '/v1/user/login', credentials, {});
}