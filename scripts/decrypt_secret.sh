cd /path/to/root/directory

gpg --quiet --batch --yes --decrypt --passphrase="$GPG_PASSPHRASE" --recipient $GPG_PRIVATE_KEY --output ./src/main/resources/application.yml ./src/main/resources/application.yml.secret