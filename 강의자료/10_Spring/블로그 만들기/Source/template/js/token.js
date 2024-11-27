const token=searchPram('token')
if(token) {
    localStorage.setItem('access_token', token)
}

function searchPram(key){
    return URLSearchParams(location.search).get(key);
}
