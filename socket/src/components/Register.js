import { useState } from "react";
import { Link } from "react-router-dom";

const Register = () => {
    const [input, setInput] = useState({});
    const onInputChange = (event) => {
        setInput((e) => ({ ...e, [event.target.name]: event.target.value }))
    }
    return (
        <div class="login-page">
            <div class="form">
                <form class="login-form">
                    <input type="text" placeholder="Full Name" name="firstName" value={input.username}
                        onChange={onInputChange} />

                    <input type="text" placeholder="Username" name="username" value={input.username}
                        onChange={onInputChange} />

                    <input type="password" placeholder="Password" value={input.username}
                        name="password"
                        onChange={onInputChange} />

                    <input type="password" placeholder="Confirm Password" value={input.username}
                        name="confirmPassword"
                        onChange={onInputChange} />

                    <button>Register</button>
                    <p class="message">Already registered? <Link to="/" >Sign In</Link></p>
                </form>
            </div>
        </div>
    )
}
export default Register;