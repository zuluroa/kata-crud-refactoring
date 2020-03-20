const HOST_API = "http://localhost:8080/api/"
export default {
    findAll : async (listId) => {
        return fetch(HOST_API + listId+"/todos")
            .then(response => response.json())
    },

    save : async (listId, request) => {
        return fetch(HOST_API + listId+"/todo", {
            method: "POST",
            body: JSON.stringify(request),
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(response => response.json())
    },

    update : async (listId, request) => {
        return fetch(HOST_API + listId+"/todo", {
            method: "PUT",
            body: JSON.stringify(request),
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(response => response.json())
    },

    delete : async (id) => {
        return fetch(HOST_API + id+"/todo", {
            method: "DELETE",
            headers: {
                'Content-Type': 'application/json'
            }
        })
    },
};