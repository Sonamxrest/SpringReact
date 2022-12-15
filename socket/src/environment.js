export  const BASE_URL = "http://localhost:8000";
export const header = () =>{
    return {
        "Authorization": `Bearer ${localStorage.getItem('token')}`,
        "ContentType": "application/json"
    }
}