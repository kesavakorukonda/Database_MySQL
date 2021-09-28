export {}

function comments() {
    alert("CallingComments");
    
    const comm = document.getElementsByClassName("CommentElements");
    if(comm)
    {
        for(var i = 0; i < comm.length; i++)
        {
            comm[i].style.visibility = "visible";
        }
    }

}
