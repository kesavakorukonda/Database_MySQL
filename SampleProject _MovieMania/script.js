
function commentsOn() {
    
    const comm = document.getElementsByClassName("CommentElements");
    
        for(var i = 0; i < comm.length; i++)
        {
            comm[i].style.visibility = "visible";
        }
    }

function commentsOff()
{
    alert("Thanks for your response - We will get back to you");

    const comm = document.getElementsByClassName("CommentElements");
    
        for(var i = 0; i < comm.length; i++)
        {
            comm[i].style.visibility = "hidden";
        }
}

function contactUsOn()
{
    const cont = document.getElementsByClassName("ContactElements");
    for(var i = 0; i < cont.length; i++)
    {
        cont[i].style.visibility = "visible";
    }
}

function contactUsOff()
{
    const cont = document.getElementsByClassName("ContactElements");
    for(var i = 0; i < cont.length; i++)
    {
        cont[i].style.visibility = "hidden";
    }
}