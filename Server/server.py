from flask import Flask, request
from sqlalchemy import create_engine

app = Flask(__name__)



db_connect = create_engine('sqlite:///base.db')




@app.route('/users', methods=['GET','POST'])
def get_users():
    # password = request.form['password']
    conn = db_connect.connect()
    query = conn.execute("select * from users")
    return str(query.cursor.fetchall())
    



@app.route('/issues', methods=['GET','POST'])
def get_issues():
    conn = db_connect.connect()
    query = conn.execute("select * from issues")
    return str(query.cursor.fetchall())
    



@app.route('/task', methods=['GET','POST'])
def get_task():
    conn = db_connect.connect()
    query = conn.execute("select * from task")
    return str(query.cursor.fetchall())
    



@app.route('/std_issues', methods=['GET','POST'])
def get_std_issues():
    conn = db_connect.connect()
    query = conn.execute("select * from std_issues")
    return str(query.cursor.fetchall())



