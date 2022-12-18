import { Route, Navigate, Outlet } from "react-router-dom";

const PrivateAuthRoute = ({auth}) =>  {
    return (auth ? <Outlet/> : <Navigate to="/"/>)
}
export default PrivateAuthRoute;