from flask import Flask, jsonify, redirect

app = Flask(__name__, static_url_path='')


@app.route("/")
def index():
    return app.send_static_file('index.html')


@app.route("/hello")
def hello():
    return jsonify({
        'name': 'hello'
    })


@app.route("/redirect")
def redirect_test():
    return redirect('/')


@app.route("/five")
def five():
    a = 1 / 0
    return jsonify({
        'name': 'five'
    })


if __name__ == "__main__":
    app.run(host='0.0.0.0', port=8888)
