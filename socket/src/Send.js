import axios from 'axios';
import React, { useEffect, useState } from 'react';
import { useParams, useSearchParams } from 'react-router-dom';
import SockJsClient from 'react-stomp';
import { getGroup } from './service/userService';

const SOCKET_URL = 'http://localhost:8000/ws-app';

const Send = () => {
    let { id } = useParams();
    const [messages, setMessages] = useState([]);
    const [message, setMessage] = useState('');
    const [group, setGroup] = useState();

    useEffect(() => {
        getGroup(id, localStorage.getItem('id')).then((res) => {
            setGroup(res.data);
            setMessages(res.data.messages === null ? [] : res.data.messages )
        });
    }, [])

    let onConnected = () => {
        console.log("Connected!!")
    }

    let onMessageReceived = (msg) => {
        setMessages((e) => [...e, { id: id, message: msg.message }]);
    }
    const sendMsg = () => {
        setMessages((e) => [...e, { id: localStorage.getItem('id'), message: message }]);
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
            <div className="menu">
                <div className="back"><i className="fa fa-chevron-left"></i> <img src="https://i.imgur.com/DY6gND0.png" draggable="false" /></div>
                <div className="name">Sender</div>
                <div className="last">18:09</div>
            </div>
            <ol className="chat">
                {

                    messages.map((d) => {
                        return (d.from.toString() === localStorage.getItem('id') ?
                            (<li className="self">
                                <div className="avatar"><img src="https://i.imgur.com/DY6gND0.png" draggable="false" /></div>
                                <div className="msg">
                                    <p>{d.message}</p>
                                    {/* <time>20:18</time> */}
                                </div>
                            </li>) : (
                                <li className="other">
                                    <div className="avatar"><img src="https://i.imgur.com/HYcn9xO.png" draggable="false" /></div>
                                    <div className="msg">
                                        <p>{d.message}</p>
                                        {/* <time>18:09</time> */}
                                    </div>
                                </li>))

                    })
                }
            </ol>
            <input className="textarea" onChange={e => setMessage(e.target.value)} value={message} type="text" placeholder="Type here!" />
            <div className="emojis">

                <button onClick={sendMsg} >Send</button>

            </div>
            <div>


            </div>
        </div>
    );
}

export default Send;