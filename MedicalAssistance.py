# # from curses import BUTTON2_CLICKED
import tkinter as tk
# from tkinter import *
# root = tk.Tk(screenName=None, baseName=None, className='Medical Health Assistance (24x7)',useTk=True)
# root.title('Medical Health Assistance (24x7)')
# root['bg'] = 'red'
# # button = tk.Button(root,anchor='center',
# #                    bg='blue',
# #                    font = ("Times","12","bold italic"),
# #                    relief='sunken',
# #                    text='Click Here !!',
# #                    width=50,
# #                    padx=0, pady=0,)
# # button.pack()

# root.geometry("500x500")

# root.mainloop()
app = tk.Tk()
app.title("bg attribute")
app.geometry('300x200')

app['bg'] = '#49A'
app.mainloop()