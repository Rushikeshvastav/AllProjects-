function revword(sent){
    return sent.split(' ').map(word => word.split('').reverse().join('')).join('');
}

const revsent = revword("This is a sunny day");
console.log(revsent);

const numberarr = [4,8,2,1,6,9,5];
const descend = numberarr.sort((a,b) => b- a);
console.log(descend);