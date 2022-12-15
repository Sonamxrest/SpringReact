import { useState } from "react";
import { Link } from "react-router-dom";
import { toast } from "react-toastify";
import { register } from "../service/userService";

const Register = () => {
    const [input, setInput] = useState({});
    const onInputChange = (event) => {
        setInput((e) => ({ ...e, [event.target.name]: event.target.value }))
    }
    const onSubmit = () => {
        if (input.password !== input.confirmPassword) {
            toast.warn("Password Did Not Matched");
            return;
        }
        register(input).then((res) => {
            toast.success("Successful Registration Now You Can Login ")
        }).catch((err) => {
            toast.error(err.response.data);
        })
    }
    return (
        <div class="login-page">
            <div class="form">
                <form class="login-form">
                    <input type="text" placeholder="Full Name" name="firstName" value={input.firstName}
                        onChange={onInputChange} />

                    <input type="text" placeholder="Username" name="username" value={input.username}
                        onChange={onInputChange} />

                    <input type="password" placeholder="Password" value={input.password}
                        name="password"
                        onChange={onInputChange} />

                    <input type="password" placeholder="Confirm Password" value={input.confirmPassword}
                        name="confirmPassword"
                        onChange={onInputChange} />
                </form>
                <button onClick={onSubmit}>Register</button>
                <p class="message">Already registered? <Link to="/" >Sign In</Link></p>
            </div>
        </div>
    )
}
export default Register;