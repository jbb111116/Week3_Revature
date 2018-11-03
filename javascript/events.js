const elements = document.getElementsByTagName('div');
for(let e of elements){
    console.log(e);
    e.addEventListener( 'click', () => {
        e.classList.add('state-two');
        alert('bubbling');
    });

    e.addEventListener('mouseout', () => {
        e.classList.toggle('state-one');
    }, true);

    e.addEventListener('mousein', () => {
        e.classList.toggle('state-three');
    }, true);
}