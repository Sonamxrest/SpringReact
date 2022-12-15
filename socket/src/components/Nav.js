import { Link } from "react-router-dom";

const Nav = () => {
    return (
        <div>
            <meta charSet="utf-8" />
            <meta httpEquiv="X-UA-Compatible" content="=&quot;IE=edge&quot;/" />
            <meta name="google" value="notranslate" />
            <title>Side Menu</title>
            <link rel="stylesheet" type="text/css" href="css/menu.css" />
            <link rel="stylesheet" type="text/css" href="https://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css" />
            <nav className="main-menu">
                <div>
                    <a className="logo" >
                    </a>
                </div>
                <div className="settings" />
                <div className="scrollbar" id="style-1">
                    <ul>
                        <li>
                            <Link to="/send">
                                <i className="fa fa-home fa-lg" />
                                <span className="nav-text">Chat</span>
                            </Link>
                        </li>
                        <li>
                            <a >
                                <i className="fa fa-user fa-lg" />
                                <span className="nav-text">Login</span>
                            </a>
                        </li>
                        <li>
                            <a >
                                <i className="fa fa-envelope-o fa-lg" />
                                <span className="nav-text">Contact</span>
                            </a>
                        </li>
                        <li>
                            <a >
                                <i className="fa fa-heart-o fa-lg" />
                                <span className="share">
                                </span></a><div className="addthis_default_style addthis_32x32_style"><a >
                                </a><div style={{ position: 'absolute', marginLeft: '56px', top: '3px' }}><a >
                                </a><a href="https://www.facebook.com" target="_blank" className="share-popup"><img src="http://icons.iconarchive.com/icons/danleech/simple/512/facebook-icon.png" width="30px" height="30px" /></a>
                                    <a href="https://twitter.com/share" target="_blank" className="share-popup"><img src="https://cdn1.iconfinder.com/data/icons/metro-ui-dock-icon-set--icons-by-dakirby/512/Twitter_alt.png" width="30px" height="30px" /></a>
                                    <a href="" target="_blank" className="share-popup"><img src="http://icons.iconarchive.com/icons/danleech/simple/512/google-plus-icon.png" width="30px" height="30px" /></a>
                                </div>
                                <span className="twitter" />
                                <span className="google" />
                                <span className="fb-like">

                                    <iframe
                                     src="//www.facebook.com/
                                     plugins/like.php?href=http%3A%2F%2Ffacebook.com%
                                     2Fstartific&width&layout=button&action=like&show_faces=false&share=false&height=35
                                     " scrolling="no" frameBorder={0} style={{ border: 'none', overflow: 'hidden', height: '35px' }} allowTransparency="true" />
                                </span>
                                <span className="nav-text">
                                </span>
                            </div></li>
                        <li className="darkerlishadow">
                            <a >
                                <i className="fa fa-clock-o fa-lg" />
                                <span className="nav-text">News</span>
                            </a>
                        </li>
                        <li className="darkerli">
                            <a >
                                <i className="fa fa-desktop fa-lg" />
                                <span className="nav-text">Technology</span>
                            </a>
                        </li>
                        <li className="darkerli">
                            <a >
                                <i className="fa fa-plane fa-lg" />
                                <span className="nav-text">Travel</span>
                            </a>
                        </li>
                        <li className="darkerli">
                            <a >
                                <i className="fa fa-shopping-cart" />
                                <span className="nav-text">Shopping</span>
                            </a>
                        </li>
                        <li className="darkerli">
                            <a >
                                <i className="fa fa-microphone fa-lg" />
                                <span className="nav-text">Film &amp; Music</span>
                            </a>
                        </li>
                        <li className="darkerli">
                            <a >
                                <i className="fa fa-flask fa-lg" />
                                <span className="nav-text">Web Tools</span>
                            </a>
                        </li>
                        <li className="darkerli">
                            <a >
                                <i className="fa fa-picture-o fa-lg" />
                                <span className="nav-text">Art &amp; Design</span>
                            </a>
                        </li>
                        <li className="darkerli">
                            <a >
                                <i className="fa fa-align-left fa-lg" />
                                <span className="nav-text">Magazines
                                </span>
                            </a>
                        </li>
                        <li className="darkerli">
                            <a >
                                <i className="fa fa-gamepad fa-lg" />
                                <span className="nav-text">Games</span>
                            </a>
                        </li>
                        <li className="darkerli">
                            <a >
                                <i className="fa fa-glass fa-lg" />
                                <span className="nav-text">Life &amp; Style
                                </span>
                            </a>
                        </li>
                        <li className="darkerlishadowdown">
                            <a >
                                <i className="fa fa-rocket fa-lg" />
                                <span className="nav-text">Fun</span>
                            </a>
                        </li>
                    </ul>
                    <li>
                        <a >
                            <i className="fa fa-question-circle fa-lg" />
                            <span className="nav-text">Help</span>
                        </a>
                    </li>
                    <ul className="logout">
                        <li>
                            <a >
                                <i className="fa fa-lightbulb-o fa-lg" />
                                <span className="nav-text">
                                    BLOG
                                </span>
                            </a>
                        </li>
                    </ul>
                </div></nav>
        </div>
    )

}
export default Nav;