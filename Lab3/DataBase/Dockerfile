FROM python:3.9

RUN mkdir -p /usr/src/app
WORKDIR /usr/src/app/


COPY . /usr/src/app/
RUN pip install --no-cache-dir -r requirements.txt

EXPOSE 27017

CMD ["python", "InitDB.py"]

