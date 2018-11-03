const getData = async function(){
    const url = 'https://www.anapioficeandfire.com/api/books/1';
    const response = await fetch(url);
    const data = await response.json();
    console.log(data);
    document.getElementById('title').innerText = data.name;

    
    for(let url of data.povCharacters){
        // const charResponse = await fetch(data.povCharacters[0]);
        const charResponse = await fetch(url);
        const charData  = await charResponse.json();
        const li = document.createElement('li');
        li.innerText = charData.name;
        document.getElementById('character-list').appendChild(li);
    }
}

getData();

/**
 * XHR - AJAX (Asynchronous JavaScript and XML)
 * XmlHttpRequest
 * Doesn't necessarily require XML.
 * 
 * Predates the fetch API and was the way we made
 * HTTP requests prior to fetch, and still is in
 * wide use today.
 */

 const xhrExample = function(){
     const url = 'https://anapioficeandfire.com/api/characters/148';

     const xhr = new XMLHttpRequest();
     
     console.log(xhr.readyState); // 0. unopened
     
     xhr.open('get',url);

     console.log(xhr.readyState) // 1. opened

     /**
      * Defining events prior to sending
      * 2. HEADERS_RECEIVED
      * 3. LOADING
      * 4. DONE
      */
     xhr.addEventListener('readystatechange',() => {
         console.log(xhr.readyState);
         if(xhr.readyState == 4){
             // do stuff
         }
     });
     xhr.addEventListener('loadend', () => {
         console.log(JSON.parse(xhr.response));
     })

     xhr.send();
 }

 xhrExample();