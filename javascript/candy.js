let getData = async function() {
    const url = 'http://localhost:8080/HalloweenCandy/candy';
    const response = await fetch(url);
    const data = await response.json();
    console.log(data);
    for (d of data){
        const box = document.createElement('div');
        box.classList.add('candy-box');
        const header = document.createElement('h4');
        box.innerText = d.name;
        box.appendChild(header);
        document.getElementById('candy-container').appendChild(box);
    }
}

const createCandyBox = function(d) {
    const box = document.createElement('div');
    box.classList.add('candy-box');
    const header = document.createElement('h4');
    box.innerText = d.name;
    box.appendChild(header);
    document.getElementById('candy-container').appendChild(box);
}

document.getElementById('submit-data')
    .addEventListener('click', async() => {
        const url = 'http://localhost:8080/HalloweenCandy/candy';
        const name = document.getElementById('name-input').value;
        const flavor = document.getElementById('flavor-input').value;
        const payload = {
            name: name,
            flavor: flavor
        };

        const response = await fetch(url, {
            method: 'POST',
            body: JSON.stringify(payload)
        });
        const data = await response.json();
        createCandyBox(data);
    })

getData();