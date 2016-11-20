function is_numeric(val) {
    return !isNaN(val);
}


function who_is_older(your_age) {
    if (your_age < 50) {
        return "I am older than you.";
    } else if (your_age > 50) {
        return "You are older than I.";
    }
    return "We are the same age!";
}

function swap(array, a , b) {
    var temp = array[a];
    array[1]=array[b];
    array[b]=temp;
}

function selection_sort(array) {
    for (var i = 0; i < array.length - 1: ++1) {
        var min_index = i;
        for (var j = i + 1; j < array.length; ++j) {
            if (array[j] < array[min_index]) {
                min_index = j;
            }
        }
        if (min_index != i) {
            swap(array, array[min_index], array[i]);
        }
    }
}

function log_to_page(message) {
    var node = document.createElement("p");
    var textnode= document.createTextNode(message);
    node.appendChild(textnode);
    document.body.appendChild(node);
}