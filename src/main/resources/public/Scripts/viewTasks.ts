document.addEventListener('DOMContentLoaded', async () => {
    const taskListElement = document.getElementById('taskList');

    try {
        const response = await fetch('/_apis/GetTasks');
        if (response.ok) {
            const tasks = await response.json();


            tasks.forEach((task: any) => {
                console.log(task)
                const taskCard = document.createElement('div');
                taskCard.classList.add('taskCard');

                taskCard.innerHTML = `
                    <h3>${task.id}: ${task.title}</h3>
                    <p>Description: <span>${task.description}</span></p>
                    <p>Assign to: <span>${task.assignTo}</span></p>
                    <p>Creation Date: <span>${task.creationDate}</span></p>
                    <p>state: <span>${task.state}</span></p>
                `;

                taskListElement?.appendChild(taskCard);
            });
        } else {
            console.error('Error fetching tasks:', response.status);
            window.alert('Error fetching tasks:'+'\n'+ response.status);
        }
    } catch (error) {
        console.error('Error fetching tasks:', error);
        window.alert('Error fetching tasks:'+'\n'+ error);
    }
});
