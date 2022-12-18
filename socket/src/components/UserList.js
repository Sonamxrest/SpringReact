import { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import { getAllUser } from "../service/userService";

const UserList = () => {
    const [data, setData] = useState([])
    useEffect(() => {
        getAllUser().then((res) => {
            setData(res.data);
            console.log('this is data', data)
        })
    }, [])
    return (
        <div>
            <table className="container">
                <thead>
                    <tr>
                        <th><h1>ID</h1></th>
                        <th><h1>Full Name</h1></th>
                        <th><h1>Username</h1></th>
                        <th><h1>Action</h1></th>
                    </tr>
                </thead>
                <tbody>
                    {data.map(d => {
                        return (
                            (d.id.toString() === localStorage.getItem('id') ? (<></>)
                                :
                                (<tr key={d.id}>
                                    <td>{d.id}</td>
                                    <td>{d.first_name}</td>
                                    <td>{d.username}</td>
                                    <td><Link to={"/chat/" + d.id} >Chat</Link></td>
                                </tr>))
                        )

                    })}
                </tbody>
            </table>
        </div>
    )


}

export default UserList;