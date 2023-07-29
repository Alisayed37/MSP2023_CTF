NightShade is a simple security capture the flag framework that is designed to make running your own contest as easy as possible. 

SCREENSHOTS
-----------

They say a screen shot is worth a thousand words.

A challenge page.
![Challenge](https://github.com/UnrealAkama/NightShade/raw/master/screenshots/challenge.png)

A jeopardy style capture the flag.
![Jeopardy Style CTF](https://github.com/UnrealAkama/NightShade/raw/master/screenshots/jeopardy_style_ctf.png)

A traditional style capture the flag.
![Listing Style CTF](https://github.com/UnrealAkama/NightShade/raw/master/screenshots/listing_style_ctf.png)

A blind style capture the flag.
![Blind Style CTF](https://github.com/UnrealAkama/NightShade/raw/master/screenshots/blind_style_ctf.png)

A user profile.
![User Profile](https://github.com/UnrealAkama/NightShade/raw/master/screenshots/user_profile.png)

A list of all the contests.
![Contest Lists](https://github.com/UnrealAkama/NightShade/raw/master/screenshots/contest_lists.png)


HOSTING/SAAS
------------

If you want someone to host your platform, contact me. If you are a non-profit or a educational group, I might be willing to host it for free.

INSTALLING
----------
Before everything, make sure to setup Postgresql correctly.
For Windows:
1. install it normally.
2. set the ENVs in `C:\Program Files\PostgreSQL\15\pg_env.bat`
3. in `PostgreSQL\15\data\postgresql.conf` replace `password_encryption = scram-sha-256` with `password_encryption = md5`
4. in `PostgreSQL\15\data\pg_hba.conf` replace `scram-sha-256` with `md5` under method
5. add `local nightshade tester md5` to `pg_hba.conf`
6. open the cmd and run `psql`, then type the password
7. create another DBUser `CREATE ROLE tester SUPERUSER PASSWORD 'test_password';` **make sure to change the password when used in production!**
8. then create the DB `CREATE DATABASE nightshade; ALTER DATABASE nightshade OWNER TO tester;`
9. then restart the server `pg_ctl.exe restart -D  "C:\Program Files\PostgreSQL\15\data"`

   
Install all the requirements in the requirements.txt

    python2 -m pip install -r requirements.txt

Now we have to setup the database. This is a bit strange because it is designed to run multiple sites at the same time but this isn't needed for most people.

    python2 manage.py migrate_schemas --shared
    python2 manage.py migrate_schemas

Now we have to add the domain we want to use so that django starts serving requests from those domains. This must all be entered in the python shell.

    python2 manage.py shell

Then change the values and enter the following statements.

    from customers.models import Client

    # create your first real tenant
    tenant = Client(domain_url='localhost',
                    schema_name='shortname',
                    name='Name of Organization')

    tenant.save() # migrate_schemas automatically called, your tenant is ready to be used!

Note on using manage.py, you will have to prefix commands with 'tenant_command'.

    python manage.py tenant_command createsuperuser

Then you will have to enter the schema you wish to use, which is the shortname/schema_name from above. After that, everything should continue to be normal. 
Speaking of which, you should go ahead and create a superuser using the command above. Then visit your.domain.here.com/admin and get started creating your first contest.

    python2 manage.py runserver 8000 # port 8000 as an example

If you run into problems, please report them. This is a new project and things may be horrible wrong. Pull requests are always welcome as well.
