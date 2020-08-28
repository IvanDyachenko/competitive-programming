{ pkgs ? import <nixpkgs> { }, ... }:

pkgs.stdenv.mkDerivation rec {
  name = "development-env";
  env = pkgs.buildEnv { name = name; paths = buildInputs; };
  buildInputs =
    let
      texlive-custom = pkgs.texlive.combine {
        inherit (pkgs.texlive) scheme-basic
          # Needed on top of scheme-basic
          latexmk ulem capt-of wrapfig metafont;
      };
    in
      [
        # Development
        pkgs.metals-emacs
        
        # Documentation
        pkgs.ditaa texlive-custom
      ];
}
