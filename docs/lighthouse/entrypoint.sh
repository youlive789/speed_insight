#!/bin/sh
set -e
lighthouse --output json --throttling-method=provided --chrome-flags="--headless --no-sandbox" --quiet --only-categories=performance --emulated-form-factor="$@"
