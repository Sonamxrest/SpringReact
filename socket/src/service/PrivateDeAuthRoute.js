import { Route, Navigate, Outlet } from "react-router-dom";

const PrivateDeAuthRoute = ({auth}) =>  {
    return (!auth ? <Outlet/> : <Navigate to="/users"/>)
}
export default PrivateDeAuthRoute;