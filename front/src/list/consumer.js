const HOST_API = "http://localhost:8080/api/"
export default {
    findAll : async () => {
        return fetch(HOST_API + "list")
            .then(response => response.json())
    },

    save : async (request) => {
        return fetch(HOST_API + "/listtodo", {
            method: "POST",
            body: JSON.stringify(request),
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(response => response.json())
    }
};