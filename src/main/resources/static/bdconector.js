const API_URL='localhost:8080';
const HTMLResponse=document.querySelector("#app");
const ul=document.createElement('ul');


fetch('${API_URL}/enterprise').then((response)=>response.json())
    .then((enterprise)=>{
      enterprise.forEach(enterprise=>{
              let elem= document.createElement('li');
              elem.appendChild(document.createTextNode('${enterprise.name} ${enterprise.document}'));
              ul.appendChild(elem);

      });

      HTMLResponse.appendChild(ul);
});

