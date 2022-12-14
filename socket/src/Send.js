import axios from 'axios';
import React, { useState } from 'react';
import SockJsClient from 'react-stomp';

const SOCKET_URL = 'http://localhost:8000/ws-app';

const Send = () => {
    const [revieved, setRecieved] = useState([]);
    const [id, setId] = useState(localStorage.getItem("id"));
    const [send, setSend] = useState([]);
    const [message, setMessage] = useState('');
    const [group, setGroup] = useState({
        "id": 1,
        "uidOne": 52,
        "uidTwo": 102,
    });

    let onConnected = () => {
        console.log("Connected!!")
    }

    let onMessageReceived = (msg) => {
        setRecieved((e) => [...e, msg.message]);
    }
    const sendMsg = () => {
        setSend((e) => [...e, message]);
        setMessage('')
        const mes = { from: id, message: message, group: group, msgType: true }
        axios.post('http://localhost:8000/v1/message/sendMessage', mes, {}).then((res) => {

        }).catch((err) => {

        })
    }

    return (
        <div>
            <SockJsClient
                url={SOCKET_URL}
                topics={['/message/receive/' + id]}
                onConnect={onConnected}
                onDisconnect={console.log("Disconnected!")}
                onMessage={msg => onMessageReceived(msg)}
                debug={false}
            />
            <div class="menu">
                <div class="back"><i class="fa fa-chevron-left"></i> <img src="https://i.imgur.com/DY6gND0.png" draggable="false" /></div>
                <div class="name">Sender</div>
                <div class="last">18:09</div>
            </div>
            <ol class="chat">
                {
                    send.map(e => {
                        return (<li class="self">
                            <div class="avatar"><img src="https://i.imgur.com/DY6gND0.png" draggable="false" /></div>
                            <div class="msg">
                                <p>{e}</p>
                                <time>20:18</time>
                            </div>
                        </li>)
                    })
                }

                {revieved.map(e => {
                    return (
                        <li class="other">
                            <div class="avatar"><img src="https://i.imgur.com/HYcn9xO.png" draggable="false" /></div>
                            <div class="msg">
                                <p>{e}</p>
                                <time>18:09</time>
                            </div>
                        </li>
                    )
                })}
            </ol>
            <input class="textarea" onChange={e => setMessage(e.target.value)} value={message} type="text" placeholder="Type here!" />
            <div class="emojis">

                <button onClick={sendMsg} >Send</button>

            </div>
            <div>


            </div>
        </div>
    );
}

export default Send;