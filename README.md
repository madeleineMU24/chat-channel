Channel komandon:
/channels ---> Post - skapa ny channel, Get - hitta alla channels
/channels/{id} ---> Get - hitta en channel med id, Put - uppdatera en channel med id, Delete - tabort en channel med id

Body-Json-format
{"name": ""}




User komandon:
/users ---> Post - skapa ny user, Get - hitta alla users
/users/{id} ---> Get -hitta  en user med id, Put - uppdatera en user med id, Delete - tabort en user med id

Body-Json-format
{"name": ""}




Post komandon:
/posts ---> Post - skapa ny post, Get - hitta alla posts
/posts/{id} ---> Get - hitta en post med id, Delete - tabort en post med id

Body-Json-format
{"message": "",
    "user": {
      "id": 
},
    "channel": {
       "id": 
}
}
