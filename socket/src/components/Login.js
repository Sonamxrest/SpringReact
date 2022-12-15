import { useState } from "react";
import { Link } from "react-router-dom";
import { toast } from "react-toastify";
import { login } from "../service/userService";

const Login = () => {
    const [input, setInput] = useState({});

    const onInputChange = (event) => {
        setInput((e) => ({ ...e, [event.target.name]: event.target.value }));
    }
    const onSubmit = () => {
        login(input).then((res) => {
            toast.success("Login Success")
            localStorage.setItem('access_token', res.data.token);
            localStorage.setItem('id', res.data.id);
            localStorage.setItem('username', res.data.username);
            window.location.href = "/users"
        }).catch((err) => {

        })
    }

    return (
        <div class="login-page">
            <div class="form">
                <form class="login-form">
                    <input type="text" placeholder="Username" name="username" value={input.username}
                        onChange={onInputChange} />
                    <input type="password" placeholder="Password" value={input.password}
                        name="password"
                        onChange={onInputChange} />

                </form>
                <button onClick={onSubmit}>login</button>
                <p class="message">Not registered? <Link to="/register">Create an account</Link></p>
            </div>
        </div>
    )
}
export default Login;