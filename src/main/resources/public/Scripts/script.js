"use strict";
var __awaiter = (this && this.__awaiter) || function (thisArg, _arguments, P, generator) {
    function adopt(value) { return value instanceof P ? value : new P(function (resolve) { resolve(value); }); }
    return new (P || (P = Promise))(function (resolve, reject) {
        function fulfilled(value) { try { step(generator.next(value)); } catch (e) { reject(e); } }
        function rejected(value) { try { step(generator["throw"](value)); } catch (e) { reject(e); } }
        function step(result) { result.done ? resolve(result.value) : adopt(result.value).then(fulfilled, rejected); }
        step((generator = generator.apply(thisArg, _arguments || [])).next());
    });
};
document.addEventListener('DOMContentLoaded', () => {
    const form = document.getElementById('taskForm');
    const submitBtn = document.getElementById('submitBtn');
    submitBtn.addEventListener('click', () => __awaiter(void 0, void 0, void 0, function* () {
        const id = document.getElementById('id').value;
        const title = document.getElementById('title').value;
        const description = document.getElementById('description').value;
        const assignTo = document.getElementById('assignTo').value;
        const newTask = {
            id,
            title,
            description,
            assignTo
        };
        try {
            const response = yield fetch('/_apis/CreateTask', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(newTask)
            });
            if (response.ok) {
                const responseData = yield response.json();
                console.log('Task created:', responseData);
            }
            else {
                console.error('Error creating task:', response.status);
            }
        }
        catch (error) {
            console.error('Error creating task:', error);
        }
    }));
});
